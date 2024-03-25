/*
 * Copyright (c) 2024, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sync.tool.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.user.core.service.RealmService;
import com.sync.tool.UserSync;

@Component(
        name = "com.sync.tool",
        immediate = true
)
public class UserSyncService {

    private static final Log log = LogFactory.getLog(UserSync.class);
    private static RealmService realmService;

    @Activate
    protected void activate(ComponentContext context) {
        
        BundleContext bundleContext = context.getBundleContext();
        bundleContext.registerService(UserSync.class.getName(), new UserSync(), null);
        
        log.info("...........................................................");
        log.info("...........................................................");
        log.info("..............User sync tool is activating...................");
        log.info("...........................................................");
        log.info("...........................................................");
        UserSync.syncUsers();
   
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {

        if (log.isDebugEnabled()) {
            log.info("User sync tool is deactivated");
        }
    }

    public static RealmService getRealmService() {

        return realmService;
    }

    @Reference(name = "user.realmservice.default",
            service = org.wso2.carbon.user.core.service.RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService")
    protected void setRealmService(RealmService realmService) {

        log.debug("Setting the Realm Service");
        UserSyncService.realmService = realmService;
    }

    protected void unsetRealmService(RealmService realmService) {

        log.debug("UnSetting the Realm Service");
        UserSyncService.realmService = null;
    }
}