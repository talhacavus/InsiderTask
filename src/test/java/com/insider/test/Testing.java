package com.insider.test;

import com.insider.driver.DriverBase;
import com.insider.page.TaskPage;
import org.junit.Test;

public class Testing extends DriverBase {

    @Test
    public void test(){
        TaskPage taskPage = new TaskPage();
        taskPage.taskTest();

    }

}
