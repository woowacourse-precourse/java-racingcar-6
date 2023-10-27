package racingcar;

class Pair implements Comparable<Pair> {
	private String name;
	private int location;
	
	protected String getName() {
		return name;
	}
	
	protected int getLocation() {
		return location;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setLocation(int location) {
		this.location = location;
	}
	
	protected void move() {
		location++;
	}
	
	@Override
	public int compareTo(final Pair p) {
		return Integer.compare(p.location, this.location);
	}
}
