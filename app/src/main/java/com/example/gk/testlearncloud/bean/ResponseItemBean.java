package com.example.gk.testlearncloud.bean;

import java.io.Serializable;

/**
 * 项目名称：TestLearnCloud
 * 类描述：
 * 创建人：gk
 * 创建时间：2016/9/10 17:01
 * 修改人：gk
 * 修改时间：2016/9/10 17:01
 * 修改备注：
 */
public class ResponseItemBean implements Serializable {
    private ServerData serverData;
    public ServerData getServerData() {
        return serverData;
    }

    public void setServerData(ServerData serverData) {
        this.serverData = serverData;
    }

    @Override
    public String toString() {
        return serverData.toString();
    }
}
