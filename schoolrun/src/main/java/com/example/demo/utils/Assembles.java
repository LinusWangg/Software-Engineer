package com.example.demo.utils;

import com.example.demo.model.Appeal;
import com.example.demo.model.Basetrace;
import com.example.demo.model.Morningclockin;
import com.example.demo.model.Runclockin;
import com.example.demo.outDTO.appealDTO;
import com.example.demo.outDTO.baseTraceDTO;
import com.example.demo.outDTO.morningClockinDTO;
import com.example.demo.outDTO.runClockinDTO;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Assembles {
    public static String timeStamp2Date(long seconds) {
        String format = "yyyy年MM月dd日 HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(seconds));
    }

    public static morningClockinDTO assemble(Morningclockin morningclockin){
        morningClockinDTO dto = new morningClockinDTO();
        dto.setClockinCode(morningclockin.getClockinCode());
        dto.setClockinIp(morningclockin.getClockinIp());
        dto.setClockinStuid(morningclockin.getClockinStuid());
        dto.getClockinStuschool(morningclockin.getClockinStuschool());
        dto.setLatitude(morningclockin.getLatitude());
        dto.setLongitude(morningclockin.getLongitude());
        dto.setClockinSucceed(morningclockin.getClockinSucceed());
        dto.setClockinTime(timeStamp2Date(morningclockin.getClockinTime()));
        dto.setTimestamp(morningclockin.getClockinTime());
        dto.setClockinStuschool(morningclockin.getClockinStuschool());
        return dto;
    }

    public static runClockinDTO assemble(Runclockin runclockin){
        runClockinDTO dto = new runClockinDTO();
        dto.setBaseid(runclockin.getBaseid());
        dto.setClockinStuschool(runclockin.getClockinStuschool());
        dto.setDtw(runclockin.getDtw());
        dto.setClockinTrace(runclockin.getClockinTrace());
        dto.setRunLength(runclockin.getRunLength());
        dto.setRunTime(runclockin.getRunTime());
        dto.setClockinIp(runclockin.getClockinIp());
        dto.setClockinSucceed(runclockin.getClockinSucceed());
        dto.setClockinTime(timeStamp2Date(runclockin.getClockinTime()));
        dto.setClockinStuid(runclockin.getClockinStuid());
        dto.setTimestamp(runclockin.getClockinTime());
        return dto;
    }

    public static appealDTO assemble(Appeal appeal){
        appealDTO dto = new appealDTO();
        dto.setAppealAdminid(appeal.getAppealAdminid());
        dto.setAppealCondition(appeal.getAppealCondition());
        dto.setAppealContent(appeal.getAppealContent());
        dto.setAppealSchool(appeal.getAppealSchool());
        dto.setAppealStuid(appeal.getAppealStuid());
        dto.setAppealTime(timeStamp2Date(appeal.getAppealTime()));
        dto.setTimestamp(appeal.getAppealTime());
        return dto;
    }

    public static baseTraceDTO assemble(Basetrace basetrace){
        baseTraceDTO dto = new baseTraceDTO();
        Gson gson = new Gson();
        dto = gson.fromJson(gson.toJson(basetrace), baseTraceDTO.class);
        return dto;
    }

}
