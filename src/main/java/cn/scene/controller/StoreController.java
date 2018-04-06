package cn.scene.controller;

import cn.scene.model.Store;
import cn.scene.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 设计小店
 */
@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    //设计小店
    @RequestMapping("/news")
    public @ResponseBody List<Store> newStore(HttpServletRequest request){
        String index = request.getParameter("page");
        String regx = "^[0-9]+$";
        List<Store> info = new ArrayList<>();
        if(index.matches(regx)){
            int page = Integer.parseInt(index);
            if(page>5){
                info = storeService.selectNewStore(page);
            }else{
                info = storeService.selectNewStore(1);
            }
        }
        return info;
    }

    //推荐小店
    @RequestMapping("/info")
    public @ResponseBody List<Store> info(HttpServletRequest request){
        String index = request.getParameter("page");
        String regx = "^[0-9]+$";
        List<Store> info = new ArrayList<>();
        if(index.matches(regx)){
            int page = Integer.parseInt(index);
            info = storeService.selectRecordStroe(page);
        }
        return info;
    }

    //查询小店总页数
    @RequestMapping("/count")
    public @ResponseBody int storeCounts(HttpServletRequest request){
        return storeService.selectStoreCounts();
    }
}