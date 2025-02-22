package net.osmand.router;

public class TransportRoutingConfiguration {

	public static final String KEY = "public_transport";
	
	public int ZOOM_TO_LOAD_TILES = 15;
	
	public int walkRadius = 1500; // ? 3000
	
	public int walkChangeRadius = 300; 
	
	public double walkSpeed = 3.6 / 3.6; // m/s
	
	public double travelSpeed = 36 / 3.6; // m/s
	
	public int stopTime = 30;
	
	public int changeTime = 300;
	
	public int maxNumberOfChanges = 5;  
	
	public int finishTimeSeconds = 1200;

	public int maxRouteTime = 60 * 60 * 10; // 10 hours

	public boolean useSchedule;
	
	// 10 seconds based
	public int scheduleTimeOfDay = 12 * 60 * 6; // 12:00 - 60*6*12
	
	public int scheduleMaxTime = 50 * 6; // TODO not appropriate variable, should be dynamic
	
	public int scheduleMinChangeTime = 180; // 3 min
	
	// day since 2000
	public int scheduleDayNumber;
	
	
	public int getChangeTime() {
		return useSchedule ? scheduleMinChangeTime : changeTime;
	}
	
	public TransportRoutingConfiguration(RoutingConfiguration.Builder builder) {
		GeneralRouter router = builder == null ? null : builder.getRouter("public_transport");
		if(router != null) {
			walkRadius =  router.getIntAttribute("walkRadius", walkRadius);
			walkChangeRadius =  router.getIntAttribute("walkChangeRadius", walkRadius);
			ZOOM_TO_LOAD_TILES =  router.getIntAttribute("zoomToLoadTiles", ZOOM_TO_LOAD_TILES);
			maxNumberOfChanges =  router.getIntAttribute("maxNumberOfChanges", maxNumberOfChanges);
			maxRouteTime =  router.getIntAttribute("maxRouteTime", maxRouteTime);
			finishTimeSeconds =  router.getIntAttribute("delayForAlternativesRoutes", finishTimeSeconds);
			
			travelSpeed =  router.getFloatAttribute("defaultTravelSpeed", (float) travelSpeed);
			walkSpeed =  router.getFloatAttribute("defaultWalkSpeed", (float) walkSpeed);
			stopTime =  router.getIntAttribute("defaultStopTime", stopTime);
			changeTime =  router.getIntAttribute("defaultChangeTime", changeTime);
			scheduleMinChangeTime =  router.getIntAttribute("defaultScheduleChangeTime", changeTime);
		}
	}
	
}
