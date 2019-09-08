/*
 * Copyright (c) 2018 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.ftp.client.actions;

import org.ballerinalang.ftp.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.transport.remotefilesystem.listener.RemoteFileSystemListener;
import org.wso2.transport.remotefilesystem.message.RemoteFileSystemBaseMessage;

import java.util.concurrent.CompletableFuture;

/**
 * {@code AbstractFtpAction} is the base class for all FTP Connector Actions.
 */
abstract class AbstractFtpAction {

    /**
     * {@link RemoteFileSystemListener} implementation for receive notification from transport.
     */
    protected static class FTPClientConnectorListener implements RemoteFileSystemListener {

        private static final Logger log = LoggerFactory.getLogger("ballerina");
        private CompletableFuture<Object> future;

        FTPClientConnectorListener(CompletableFuture<Object> future) {

            this.future = future;
        }

        public CompletableFuture<Object> getFuture() {

            return future;
        }

        @Override
        public boolean onMessage(RemoteFileSystemBaseMessage remoteFileSystemBaseMessage) {
            // This default implementation handles the situation where no response is returned from the transport side.
            // If there is any response coming from transport then it specifically needs to be handled from the relevant
            // action class by overriding this method.
            future.complete(null);
            return true;
        }

        @Override
        public void onError(Throwable throwable) {

            log.error(throwable.getMessage(), throwable);
            future.complete(FTPUtil.createError(throwable.getMessage()));
        }

        @Override
        public void done() {

        }
    }
}