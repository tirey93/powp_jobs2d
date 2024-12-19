package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;
	private final ILine line;

	public LineDrawerAdapter(LineType lineType) {
		super();
		line = setLine(lineType);
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		DrawerFeature.getDrawerController().drawLine(line);
		setPosition(x, y);
	}

	@Override
	public String toString() {
		return "LineDrawerAdapter";
	}

	private ILine setLine(LineType lineType) {
		if(lineType.equals(LineType.BASIC))
			return LineFactory.getBasicLine();
		if(lineType.equals(LineType.DOTTED))
			return LineFactory.getDottedLine();
		if(lineType.equals(LineType.SPECIAL))
			return LineFactory.getSpecialLine();
		return null;
	}
}
