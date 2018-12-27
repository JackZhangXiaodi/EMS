package com.baizhi.entity;

import java.io.Serializable;
import java.util.Objects;

public class Permission implements Serializable {
    private String id;
    private String resourceName;//资源名称
    private String resourceUrl;//资源路径
    private String resourceTag;//资源小图标
    private String permissionTag;//控制标签
    private String parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(resourceName, that.resourceName) &&
                Objects.equals(resourceUrl, that.resourceUrl) &&
                Objects.equals(resourceTag, that.resourceTag) &&
                Objects.equals(permissionTag, that.permissionTag) &&
                Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceName, resourceUrl, resourceTag, permissionTag, parentId);
    }

    public Permission() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Permission(String id, String resourceName, String resourceUrl, String resourceTag, String permissionTag, String parentId) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceTag = resourceTag;
        this.permissionTag = permissionTag;
        this.parentId = parentId;
    }
}
