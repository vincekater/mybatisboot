package com.szpnr.plsup.mybatis.model;

import java.io.Serializable;

public class PlsupLocation implements Serializable {
    private Short locationId;

    private String locationName;

    private String locationCode;

    private String locationLevel;

    private String parentCode;

    private String locationCodeJcgis;

    private String locationCodeIbms1;

    private String locationCodeIbms2;

    private String isDel;

    private String locationAddr;

    private String locationTel;

    private String remark;

    private String locationCodeIbmsZone;

    private String locationCodeIbmsSub;

    private Short locationArea;

    private String locationIbmsCode;

    private String locationIbmsLevel;

    private static final long serialVersionUID = 1L;

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode == null ? null : locationCode.trim();
    }

    public String getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel == null ? null : locationLevel.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getLocationCodeJcgis() {
        return locationCodeJcgis;
    }

    public void setLocationCodeJcgis(String locationCodeJcgis) {
        this.locationCodeJcgis = locationCodeJcgis == null ? null : locationCodeJcgis.trim();
    }

    public String getLocationCodeIbms1() {
        return locationCodeIbms1;
    }

    public void setLocationCodeIbms1(String locationCodeIbms1) {
        this.locationCodeIbms1 = locationCodeIbms1 == null ? null : locationCodeIbms1.trim();
    }

    public String getLocationCodeIbms2() {
        return locationCodeIbms2;
    }

    public void setLocationCodeIbms2(String locationCodeIbms2) {
        this.locationCodeIbms2 = locationCodeIbms2 == null ? null : locationCodeIbms2.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getLocationAddr() {
        return locationAddr;
    }

    public void setLocationAddr(String locationAddr) {
        this.locationAddr = locationAddr == null ? null : locationAddr.trim();
    }

    public String getLocationTel() {
        return locationTel;
    }

    public void setLocationTel(String locationTel) {
        this.locationTel = locationTel == null ? null : locationTel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getLocationCodeIbmsZone() {
        return locationCodeIbmsZone;
    }

    public void setLocationCodeIbmsZone(String locationCodeIbmsZone) {
        this.locationCodeIbmsZone = locationCodeIbmsZone == null ? null : locationCodeIbmsZone.trim();
    }

    public String getLocationCodeIbmsSub() {
        return locationCodeIbmsSub;
    }

    public void setLocationCodeIbmsSub(String locationCodeIbmsSub) {
        this.locationCodeIbmsSub = locationCodeIbmsSub == null ? null : locationCodeIbmsSub.trim();
    }

    public Short getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(Short locationArea) {
        this.locationArea = locationArea;
    }

    public String getLocationIbmsCode() {
        return locationIbmsCode;
    }

    public void setLocationIbmsCode(String locationIbmsCode) {
        this.locationIbmsCode = locationIbmsCode == null ? null : locationIbmsCode.trim();
    }

    public String getLocationIbmsLevel() {
        return locationIbmsLevel;
    }

    public void setLocationIbmsLevel(String locationIbmsLevel) {
        this.locationIbmsLevel = locationIbmsLevel == null ? null : locationIbmsLevel.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PlsupLocation other = (PlsupLocation) that;
        return (this.getLocationId() == null ? other.getLocationId() == null : this.getLocationId().equals(other.getLocationId()))
            && (this.getLocationName() == null ? other.getLocationName() == null : this.getLocationName().equals(other.getLocationName()))
            && (this.getLocationCode() == null ? other.getLocationCode() == null : this.getLocationCode().equals(other.getLocationCode()))
            && (this.getLocationLevel() == null ? other.getLocationLevel() == null : this.getLocationLevel().equals(other.getLocationLevel()))
            && (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))
            && (this.getLocationCodeJcgis() == null ? other.getLocationCodeJcgis() == null : this.getLocationCodeJcgis().equals(other.getLocationCodeJcgis()))
            && (this.getLocationCodeIbms1() == null ? other.getLocationCodeIbms1() == null : this.getLocationCodeIbms1().equals(other.getLocationCodeIbms1()))
            && (this.getLocationCodeIbms2() == null ? other.getLocationCodeIbms2() == null : this.getLocationCodeIbms2().equals(other.getLocationCodeIbms2()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getLocationAddr() == null ? other.getLocationAddr() == null : this.getLocationAddr().equals(other.getLocationAddr()))
            && (this.getLocationTel() == null ? other.getLocationTel() == null : this.getLocationTel().equals(other.getLocationTel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getLocationCodeIbmsZone() == null ? other.getLocationCodeIbmsZone() == null : this.getLocationCodeIbmsZone().equals(other.getLocationCodeIbmsZone()))
            && (this.getLocationCodeIbmsSub() == null ? other.getLocationCodeIbmsSub() == null : this.getLocationCodeIbmsSub().equals(other.getLocationCodeIbmsSub()))
            && (this.getLocationArea() == null ? other.getLocationArea() == null : this.getLocationArea().equals(other.getLocationArea()))
            && (this.getLocationIbmsCode() == null ? other.getLocationIbmsCode() == null : this.getLocationIbmsCode().equals(other.getLocationIbmsCode()))
            && (this.getLocationIbmsLevel() == null ? other.getLocationIbmsLevel() == null : this.getLocationIbmsLevel().equals(other.getLocationIbmsLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLocationId() == null) ? 0 : getLocationId().hashCode());
        result = prime * result + ((getLocationName() == null) ? 0 : getLocationName().hashCode());
        result = prime * result + ((getLocationCode() == null) ? 0 : getLocationCode().hashCode());
        result = prime * result + ((getLocationLevel() == null) ? 0 : getLocationLevel().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getLocationCodeJcgis() == null) ? 0 : getLocationCodeJcgis().hashCode());
        result = prime * result + ((getLocationCodeIbms1() == null) ? 0 : getLocationCodeIbms1().hashCode());
        result = prime * result + ((getLocationCodeIbms2() == null) ? 0 : getLocationCodeIbms2().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getLocationAddr() == null) ? 0 : getLocationAddr().hashCode());
        result = prime * result + ((getLocationTel() == null) ? 0 : getLocationTel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLocationCodeIbmsZone() == null) ? 0 : getLocationCodeIbmsZone().hashCode());
        result = prime * result + ((getLocationCodeIbmsSub() == null) ? 0 : getLocationCodeIbmsSub().hashCode());
        result = prime * result + ((getLocationArea() == null) ? 0 : getLocationArea().hashCode());
        result = prime * result + ((getLocationIbmsCode() == null) ? 0 : getLocationIbmsCode().hashCode());
        result = prime * result + ((getLocationIbmsLevel() == null) ? 0 : getLocationIbmsLevel().hashCode());
        return result;
    }
}