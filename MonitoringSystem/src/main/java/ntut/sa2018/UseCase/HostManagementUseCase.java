package ntut.sa2018.UseCase;

import com.google.gson.Gson;
import ntut.sa2018.DTO.HostInputDTO;
import ntut.sa2018.DTO.HostOutputDTO;
import ntut.sa2018.Domain.Contact.Contact;
import ntut.sa2018.Domain.Contact.ContactBuilder;
import ntut.sa2018.Domain.Host.Host;
import ntut.sa2018.Domain.Host.HostBuilder;
import ntut.sa2018.Others.Interface.HostManagementRepository;
import ntut.sa2018.Others.HostManagement.HostManagementDirector;

import java.util.ArrayList;

public class HostManagementUseCase {
    private static HostManagementUseCase instance = null;
    private HostManagementRepository hostRepository;
    private ArrayList<Host> hostList;

    private HostManagementUseCase(){
        hostRepository = HostManagementDirector.StorageBuild();
        hostList = hostRepository.getHost();
    }

    public static HostManagementUseCase Use() {
        if (instance == null) {
            instance = new HostManagementUseCase();
        }
        return instance;
    }

    public ArrayList<HostOutputDTO> GetHostListDTO(){
        //use the storage way to get the host list
        ArrayList<HostOutputDTO> hostOutputDTOArrayList =new ArrayList<HostOutputDTO>();
        for(int i=0;i<hostList.size();i++){
            HostOutputDTO hostOutputDTO =new HostOutputDTO();
            hostOutputDTO.hostName=hostList.get(i).getHostName();
            hostOutputDTO.hostIp=hostList.get(i).getHostIP();
            hostOutputDTO.status=hostList.get(i).getHostStatus();
            hostOutputDTO.lastCheck=hostList.get(i).getLastCheck();
            hostOutputDTOArrayList.add(hostOutputDTO);
        }

        return hostOutputDTOArrayList;
    }

    public ArrayList<Host> GetHostList(){
        return hostList;
    }

    public String AddHost(HostInputDTO hostInputDTO){
        String result = "{ \"result\" : true }" ;
        /*WARNING!!!! check method, interval  and contact wait jsp inplement*/
        Contact contact=new ContactBuilder.newInstance().
                contactName("賴偉程").
                email("t106598064@ntut.edu.tw").
                build();
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        contactArrayList.add(contact);

        try{
            Host host = new HostBuilder.newInstance().
                    name(hostInputDTO.hostName).
                    address(hostInputDTO.hostIp).
                    checkCommand("Reachable").
                    checkInterval(5).
                    contact(contactArrayList).
                    build();
            this.hostRepository.addHost(host);
            this.hostList = hostRepository.getHost();
            result = "{ \"result\" : true , \"data\" : [" + getHostListJson(GetHostListDTO()) + " }" ;
        }
        catch (Exception ex){
            System.out.println("add host fails, result = " + ex.toString());
            result = "{ \"result\" : false }" ;
        }
        return result;
    }

    public String DeleteHost(String hostIp){
        String result = "{ \"result\" : true }" ;
        try {
            this.hostRepository.deleteHost(hostIp);
            this.hostList = hostRepository.getHost();
            result = "{ \"result\" : true , \"data\" : [" + getHostListJson(GetHostListDTO()) + " }" ;
        }catch(Exception ex){
            System.out.println("delete host fails, result = " + ex.toString());
            result = "{ \"result\" : false }" ;
        }
        return result;
    }

    public String getHostListJson(ArrayList<HostOutputDTO> hostList){
        Gson gson = new Gson();
        String json = gson.toJson(hostList);
        return json;
    }
}
