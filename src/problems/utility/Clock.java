package problems.utility;

public class Clock {

	/**
	 * Keeps track of the previous time.
	 */
	private long prev;
	
	
	/**
	 * Used to check if the time has elapsed over the amount of the target time in milliseconds
	 */
	private long targetTime;
	
	/**
	 * Constructs a clock with previous set to the current time.
	 */
	public Clock(){
		prev = System.currentTimeMillis();
		targetTime = 0;
	}
	
	/**
	 * Constructs a clock with the given target time
	 * @param targetTime The time (in milliseconds) to check if it is over the target time or not
	 */
	public Clock(long targetTime){
		prev = System.currentTimeMillis();
		this.targetTime = targetTime;
	}
	
	/**
	 * Brings back the elapsed time and resets the clock.
	 * @return The elapsed time.
	 */
	public long delta(){
		long current = System.currentTimeMillis();
		long previous = prev;
	
		prev = current;
		return (current - previous);
	}
	
	/**
	 * Brings back the elapsed time but does not reset the clock.
	 * @return The elapsed time.
	 */
	public long split(){
		long current = System.currentTimeMillis();
		return (current - prev);
	}
	
	/**
	 * Checks to see if the current split is over the target time.
	 * @return Returns true if over target time, otherwise false
	 */
	public boolean overTargetTime(){
		boolean ret = (this.split() > targetTime);
		return ret;
	}
}
