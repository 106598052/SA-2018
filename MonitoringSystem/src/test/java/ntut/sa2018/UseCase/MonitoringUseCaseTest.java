package ntut.sa2018.UseCase;

import ntut.sa2018.Domain.Contact.Contact;
import ntut.sa2018.Domain.Contact.ContactBuilder;
import ntut.sa2018.Domain.Host.Host;
import ntut.sa2018.Domain.Host.HostBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class MonitoringUseCaseTest {
    Contact contact;
    @Before
    public void setup(){
        contact = new ContactBuilder.newInstance().
                contactName("賴偉程").
                email("test@ntut.edu.tw").
                build();
    }

    /*
    @Test
    public void MonitoringUseCaseTest() throws InterruptedException {
        MonitoringUseCase monitoringUseCase = new MonitoringUseCase();

        ArrayList<Host> HostList  = new ArrayList<Host>();
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("127.0.0.1").
                contact(contact).
                checkCommand("Reachable").
                checkInterval(5).
                build();

        Host hostB = new HostBuilder.newInstance().
                name("jay").
                address("192.168.1.2").
                contact(contact).
                checkCommand("Reachable").
                checkInterval(10).
                build();

        HostList.add(hostA);
        HostList.add(hostB);

        monitoringUseCase.run(HostList);
        assertEquals(null, hostA.getHostStatus());
        assertEquals(null, hostB.getHostStatus());
        Thread.sleep(2000);
        assertEquals("OK", hostA.getHostStatus());
        assertEquals("ERROR", hostB.getHostStatus());
    }

    @Test
    public void Monitoring_Host_WithoutContact_Test() throws InterruptedException {
        MonitoringUseCase monitoringUseCase = new MonitoringUseCase();

        ArrayList<Host> HostList  = new ArrayList<Host>();
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("127.0.0.1").
                checkCommand("Reachable").
                checkInterval(5).
                build();

        Host hostB = new HostBuilder.newInstance().
                name("jay").
                address("192.168.1.2").
                checkCommand("Reachable").
                checkInterval(10).
                build();

        HostList.add(hostA);
        HostList.add(hostB);

        monitoringUseCase.run(HostList);
        assertEquals(null, hostA.getHostStatus());
        assertEquals(null, hostB.getHostStatus());
        Thread.sleep(2000);
        assertEquals("OK", hostA.getHostStatus());
        assertEquals("ERROR", hostB.getHostStatus());
    }*/
}