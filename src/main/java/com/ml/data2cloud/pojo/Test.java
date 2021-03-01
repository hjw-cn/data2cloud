package com.ml.data2cloud.pojo;

/**
 * @author hanjiawei
 * @date 2021-03-01
 */
public class Test {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
