package com.te.cms.entity;

public enum AddressType {

    PERMANENT("permanent"),TEMPORARY("temporary");

    String type;

 AddressType(String type){
        this.type=type;

    }
}
