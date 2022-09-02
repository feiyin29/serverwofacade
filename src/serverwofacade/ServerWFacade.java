/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author feiyi
 */
public class ServerWFacade {
    private static ServerWFacade myFacadeObj = null;
    private ServerWFacade(){}
    public static ServerWFacade getMyFacadeObj() {
        if (myFacadeObj == null) {
            myFacadeObj = new ServerWFacade();
        }
return myFacadeObj;
    }
    
    public void startSchedule(){
        ScheduleServer scheduleServer = new ScheduleServer();
        scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
	System.out.println("Start working......");
    }
    public void stopSchedule(){
        ScheduleServer scheduleServer = new ScheduleServer();
        System.out.println("After work done.........");
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
