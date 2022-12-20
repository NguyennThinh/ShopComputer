package Model;

public class ProductDetail {
	private String id;
	private String cpu, mainboard, ram, rom, card, power, frames, radiators;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMainboard() {
		return mainboard;
	}
	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getFrames() {
		return frames;
	}
	public void setFrames(String frames) {
		this.frames = frames;
	}
	public String getRadiators() {
		return radiators;
	}
	public void setRadiators(String radiators) {
		this.radiators = radiators;
	}
	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetail(String id, String cpu, String mainboard, String ram, String rom, String card, String power,
			String frames, String radiators) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.ram = ram;
		this.rom = rom;
		this.card = card;
		this.power = power;
		this.frames = frames;
		this.radiators = radiators;
	}
	public ProductDetail( String cpu, String mainboard, String ram, String rom, String card, String power,
			String frames, String radiators) {
		super();
	
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.ram = ram;
		this.rom = rom;
		this.card = card;
		this.power = power;
		this.frames = frames;
		this.radiators = radiators;
	}
	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", cpu=" + cpu + ", mainboard=" + mainboard + ", ram=" + ram + ", rom=" + rom
				+ ", card=" + card + ", power=" + power + ", frames=" + frames + ", radiators=" + radiators + "]";
	}
	
}
