package com.zwj.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if(StringUtils.isEmpty(ipAddress) || "unkown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if(StringUtils.isEmpty(ipAddress) || "unkown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if(StringUtils.isEmpty(ipAddress) || "unkown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }
}
