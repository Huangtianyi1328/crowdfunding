package com.huangtianyi.crowd.util;

/**
* 统一整个项目中ajax请求返回的结果(未来也可以用于分布式架构各个模块间调用时返回统一类型)
* @author huangtianyi
* @Date 2022/6/7 10:12
*/
public class ResultEntity<T> {

    public final static String SUCCESS = "SUCCESS";
    public final static String FAILED = "FAILED";
    //用来封装当前请求处理的结果是成功还是失败
    private String result;
    //请求处理失败时返回的错误信息
    private String msg;
    //请求处理成功时返回的数据
    private T data;

    /**
     * 请求处理成功且不需要返回数据的工具方法
     * @param <Type>
     * @return
     */
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }

    /**
     * 请求处理成功且需要返回数据的工具方法
     * @param data 成功后返回的数据
     * @return
     */
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(SUCCESS,null,data);
    }

    /**
     * 请求处理失败后使用的工具方法
     * @param msg 失败的错误消息
     * @return
     */
    public static <Type> ResultEntity<Type> failed(String msg){
        return new ResultEntity<Type>(FAILED,msg,null);
    }
    public ResultEntity() {
    }

    public ResultEntity(String result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
