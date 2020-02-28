package com.szpnr.plsup.config;

import com.octo.captcha.CaptchaFactory;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.SingleColorGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.BaffleTextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.engine.GenericCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
/**
 * 验证码的图片复杂度配置类
 */
@Configuration
public class CaptchaConfig {

    public Color colorDimGrey() {
        Color color = new Color(105,105,105);
        return color;
    }

    public Color colorWrite() {
        Color color = new Color(255,255,255);
        return color;
    }

    public SingleColorGenerator colorGen() {
        SingleColorGenerator color = new SingleColorGenerator(colorDimGrey());
        return color;
    }


    public BaffleTextDecorator baffleDecorator() {
        BaffleTextDecorator decorator = new BaffleTextDecorator(1,colorWrite());
        return decorator;
    }


    public DecoratedRandomTextPaster decoratedPaster() {
        DecoratedRandomTextPaster textPaster = new DecoratedRandomTextPaster(4,
                4,colorGen(),null);
        return textPaster;
    }

    public UniColorBackgroundGenerator backGenUni() {
        return new UniColorBackgroundGenerator(80,32);
    }


    public RandomFontGenerator fontGenRandom() {
        return new RandomFontGenerator(20,20,new Font[]{new Font("Arial",0,20)});
    }


    public ComposedWordToImage wordtoimage() {
        return new ComposedWordToImage(fontGenRandom(),backGenUni(),decoratedPaster());
    }

    public RandomWordGenerator wordgen() {
        return new RandomWordGenerator("0123456789abcdefghijklmnopqrstuvwxyz");
    }

    public GimpyFactory captchaFactory() {
        return new GimpyFactory(wordgen(),wordtoimage());
    }

    @Bean
    public GenericCaptchaEngine imageEngine() {
        return new GenericCaptchaEngine(new CaptchaFactory[]{captchaFactory()});
    }

    @Bean
    public GenericManageableCaptchaService captchaService() {
        return new GenericManageableCaptchaService(imageEngine(),180,100000);
    }
}
