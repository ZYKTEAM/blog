package com.myblog.common.utils;

import com.myblog.common.exception.BusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Jsoup 工具类
 */
public class JsoupUtils {
    private static final String UA_PHONE = "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Safari/537.36";
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

    private static final int TIME_OUT = 10 * 1000;

    private static final String ERROR_DESC = "网址请求失败：";

    private static final Log log = LogFactory.getLog(JsoupUtils.class);

    public static Document getDocWithPC(String url) throws BusinessException {
        try {
            return Jsoup.connect(url).userAgent(UA_PC).timeout(TIME_OUT).ignoreContentType(true).get();
        } catch (Exception e) {
            log.error(ERROR_DESC + url);
            throw new BusinessException(ERROR_DESC + url);
        }
    }

    public static Document getDocWithPhone(String url) throws BusinessException {
        try {
            return Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).ignoreContentType(true).validateTLSCertificates(false).get();
        } catch (IOException e) {
            log.error(ERROR_DESC + url);
            throw new BusinessException(ERROR_DESC + url);
        }
    }

    public static Document getDocWithPhone(String url, String cookie) throws BusinessException {
        try {
            return Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).header("Cookie", cookie).ignoreContentType(true).get();
        } catch (IOException e) {
            log.error(ERROR_DESC + url);
            throw new BusinessException(ERROR_DESC + url);
        }
    }


}