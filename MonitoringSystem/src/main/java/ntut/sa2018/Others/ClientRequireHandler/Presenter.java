package ntut.sa2018.Others.ClientRequireHandler;

import com.google.gson.Gson;
import ntut.sa2018.DTO.HostInputDTO;
import ntut.sa2018.DTO.HostOutputDTO;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {
    public String getHostListJson(ArrayList<HostOutputDTO> hostList){
        Gson gson = new Gson();
        String json = gson.toJson(hostList);
        return json;
    }

    public HostInputDTO setHostInputDTO(Map<String,String> clientMsg){
        HostInputDTO hostInputDTO =new HostInputDTO();
        hostInputDTO.hostIp=clientMsg.get("hostIp");
        hostInputDTO.hostName=clientMsg.get("hostName");
        return  hostInputDTO;
    }
}
