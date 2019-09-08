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

package org.ballerinalang.ftp.server;

//import org.ballerinalang.bre.bvm.CallableUnitCallback;
import org.ballerinalang.model.values.BError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@code FTPCallableUnitCallback} is the responsible for acting on notifications received from Ballerina side.
 */
public class FTPCallableUnitCallback {

    private static final Logger log = LoggerFactory.getLogger(FTPCallableUnitCallback.class);

    public void notifySuccess() {
        log.debug("File Listener: event deliver successfully.");
    }

    public void notifyFailure(BError error) {
        log.debug("File Listener: event deliver failed.");
    }
}