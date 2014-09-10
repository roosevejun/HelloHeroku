package com.tongtu.controller;

import com.tongtu.bean.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 17:19
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/terminal")
public class TerminalController {
    @RequestMapping(value = "/{imei}", method = RequestMethod.POST)
    @ResponseBody
    public Terminal updateTerminal(@PathVariable("imei") String id,@RequestBody Terminal terminal) {
//        Terminal terminal = new Terminal();
        terminal.setId(UUID.randomUUID().toString());
        return terminal;
    }
    @RequestMapping(value = "/bindAppTerminal", method = RequestMethod.POST)
    @ResponseBody
    public Appterminal bindAppTerminal(@RequestBody Appterminal appterminal) {
        return appterminal;
    }
}
