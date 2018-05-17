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

public class CheckHostUseCaseTest {
    @Test
    public void Check_Host_By_Reachable_OK() throws InterruptedException {
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("127.0.0.1").
                checkCommand("Reachable").
                checkInterval(5).
                build();

        CheckHostUseCase checkHostUseCase = new CheckHostUseCase();
        checkHostUseCase.run(hostA);

        assertEquals("OK", hostA.getHostStatus());
    }

    @Test
    public void Check_Host_By_Reachable_Error() throws InterruptedException {
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("198.25.5.3").
                checkCommand("Reachable").
                checkInterval(5).
                build();

        CheckHostUseCase checkHostUseCase = new CheckHostUseCase();
        checkHostUseCase.run(hostA);

        assertEquals("ERROR", hostA.getHostStatus());
    }

    @Test
    public void Check_Host_By_Console_OK() throws InterruptedException {
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("127.0.0.1").
                checkCommand("Console").
                checkInterval(5).
                build();

        CheckHostUseCase checkHostUseCase = new CheckHostUseCase();
        checkHostUseCase.run(hostA);

        assertEquals("OK", hostA.getHostStatus());
    }

    @Test
    public void Check_Host_By_Console_Error() throws InterruptedException {
        Host hostA = new HostBuilder.newInstance().
                name("tom").
                address("198.25.5.3").
                checkCommand("Console").
                checkInterval(2).
                build();

        CheckHostUseCase checkHostUseCase = new CheckHostUseCase();
        checkHostUseCase.run(hostA);

        assertEquals("ERROR", hostA.getHostStatus());
    }
}