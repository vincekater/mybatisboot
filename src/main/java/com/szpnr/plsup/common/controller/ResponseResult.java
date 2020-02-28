package com.szpnr.plsup.common.controller;

import io.swagger.annotations.ApiModelProperty;

public class ResponseResult {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    @ApiModelProperty(notes = "调用后消息描述")
    private Meta meta;
    @ApiModelProperty(notes = "调用后返回的数据")
    private Object data;

    public ResponseResult success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public ResponseResult success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public ResponseResult failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public ResponseResult failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public ResponseResult failure(String message,String type) {
        this.meta = new Meta(false, message,type);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }
    public class Meta {
        @ApiModelProperty(notes = "是否成功,true 成功 false失败")
        private boolean success;
        @ApiModelProperty(notes = "调用成功后的消息描述")
        private String message;
        /**
         *
         */
        @ApiModelProperty(notes = "类型描述说明调用接口的类型默认business")
        private String type;

        public Meta(boolean success) {
            this.success = success;
        }

        /**
         * 默认为type为business
         * @param success
         * @param message
         */
        public Meta(boolean success, String message) {
            this(success,message,"business");
        }

        public Meta(boolean success, String message,String type) {
            this.success = success;
            this.message = message;
            this.type = type;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public String getType() {
            return type;
        }
    }

}
