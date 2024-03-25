package com.sync.tool.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.wso2.carbon.user.core.service.RealmService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sync.tool.SyncTool;


@Component(
    name = "com.sync.tool",
    immediate = true
)
public class SyncToolService {

    private static final Log log = LogFactory.getLog(SyncTool.class);
    private static RealmService realmService;

    @Activate
    protected void activate(ComponentContext context) {
        BundleContext bundleContext = context.getBundleContext();
        SyncTool syncTool = new SyncTool();
        bundleContext.registerService(SyncTool.class.getName(), syncTool, null);
        log.info("SyncTool bundle is activated");
        log.info("-------------------------------------");
        log.info("-------------------------------------");
        log.info("-------------------------------------");
        log.info("-------------------------------------");

        syncTool.read();

    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        log.info("SyncTool bundle is deactivated");
    }
    
}
