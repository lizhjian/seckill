package org.seckill.web;

import com.alibaba.fastjson.JSONObject;
import org.seckill.dto.Exposer;
import org.seckill.dto.SecKillResult;
import org.seckill.dto.SeckillResponse;
import org.seckill.entity.SecKill;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * desc ：秒杀类
 * author ：lizj
 * date ：2020-03-29 15:07
 * </pre>
 */
@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<SecKill> seckills = seckillService.getSeckillList();
        model.addAttribute("list",seckills);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        if(seckillId==null){
            return "forward:/seckill/list";
        }
        SecKill seckill = seckillService.getSeckillById(seckillId);
        if(seckill==null){
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SecKillResult<Long> getTimeNow(){
        Date date = new Date();
        return new SecKillResult<Long>(true,date.getTime());
    }

    //ajax ,json暴露秒杀接口的方法
//    @RequestMapping(value = "/{seckillId}/exposer",
//            method = RequestMethod.GET,
//            produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
//        SeckillResult<Exposer> result;
//        try {
//            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
//            result = new SeckillResult<Exposer>(true,exposer);
//        }catch (Exception e){
//            result = new SeckillResult<Exposer>(false,e.getMessage());
//        }
//        return result;
//    }

    /**
     * desc : 执行秒杀
     * @author lizj
     * @date 2020-03-29 15:19:49
     * @param jsonObject
     * @return org.seckill.dto.SecKillResult<org.seckill.dto.SeckillResponse>
     */
    @RequestMapping(value = "/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SecKillResult<SeckillResponse> execute(@RequestBody JSONObject jsonObject){

        String userPhone = jsonObject.getString("userPhone");
        Long seckillId = jsonObject.getLong("seckillId");
        if(userPhone == null){
            return new SecKillResult<SeckillResponse>(true,"未注册");
        }
        try {
            SeckillResponse seckillExecution = seckillService.executeSeckill(seckillId,userPhone,null);
            return new SecKillResult<SeckillResponse>(true,seckillExecution);
        }catch (RepeatKillException e){
            return new SecKillResult<SeckillResponse>(true,new SeckillResponse(seckillId,SeckillStateEnum.REPEAT_KILL));
        }catch (SeckillCloseException e){
            return new SecKillResult<SeckillResponse>(true,new SeckillResponse(seckillId,SeckillStateEnum.END));
        }catch (SeckillException e){
            return new SecKillResult<SeckillResponse>(true,new SeckillResponse(seckillId,SeckillStateEnum.INNER_ERROR));
        }
    }
}