package com.land.ch.redpacketrain.bean;

import android.provider.ContactsContract;

import java.util.List;

/**
 * Created by CH
 * on 2018/10/10 16:38
 */
public class MineBean {
    public List<MineData> mineData;

    public MineBean(List<MineData> mineData) {
        this.mineData = mineData;
    }

    public List<MineData> getMineData() {
        return mineData;
    }

    public void setMineData(List<MineData> mineData) {
        this.mineData = mineData;
    }

    public static class MineData {
        public int icon;
        public String title;
        public boolean canDetail;

        public MineData(int icon, String title, boolean canDetail) {
            this.icon = icon;
            this.title = title;
            this.canDetail = canDetail;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCanDetail() {
            return canDetail;
        }

        public void setCanDetail(boolean canDetail) {
            this.canDetail = canDetail;
        }
    }


}
