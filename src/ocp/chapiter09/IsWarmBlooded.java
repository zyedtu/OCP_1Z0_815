package ocp.chapiter09;

public interface IsWarmBlooded {
	boolean hasScales();
	public default double getTemperature() {
		return 10.0;
	}
}
