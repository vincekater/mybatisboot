package com.szpnr.plsup.base.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码生成
 *
 * @author libo
 * @date 2018-04-10
 */
@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {


    @Autowired
    Producer producer;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImageCaptchaService imageCaptchaService;

    /**
     * 生成验证码
     */
    @RequestMapping("")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = producer.createText();

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write the data out
        try {
            ImageIO.write(bi, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//
//    @RequestMapping
//    @NotValid
//    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//            String captchaId = request.getSession().getId();
//            BufferedImage challenge = imageCaptchaService.getImageChallengeForID(captchaId, request.getLocale());
//
//            response.setHeader("Cache-Control", "no-store");
//            response.setHeader("Pragma", "no-cache");
//            response.setDateHeader("Expires", 0L);
//            response.setContentType("image/jpeg");
//
//            ImageIO.write(challenge, "jpeg", jpegOutputStream);
//            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//
//            ServletOutputStream respOs = response.getOutputStream();
//            respOs.write(captchaChallengeAsJpeg);
//            respOs.flush();
//            respOs.close();
//        } catch (IOException e) {
//            logger.error("generate captcha image error: {}", e.getMessage());
//        }
//    }
}
