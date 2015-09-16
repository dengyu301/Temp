package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class ControlButtons - It acts as the panel for all the buttons and has all
 * the action listeners of the buttons.
 * 
 *
 */

public class ControlButtons extends JPanel implements Observer 
{
	private static final long serialVersionUID = 1L;
	private Command theCommand;
	private int gameState;
	private GameDriver gameDriver;
	private GameBoard game;
	private DisplayClock clock;
	private TimerObservable timerObs;
	private boolean isPaused;
	private boolean isStart;
	private LayoutManager layoutType;
	private int layoutState;

	public JButton st_but = new JButton("Start");
	public JButton st_pse = new JButton("Pause");
	public JButton st_undo = new JButton("Undo");
	public JButton st_replay = new JButton("Replay");
	public JButton st_quit = new JButton("Quit");

	
	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public TimerObservable getTimerObs() {
		return timerObs;
	}

	public void setTimerObs(TimerObservable timerObs) {
		this.timerObs = timerObs;
	}

	public GameBoard getGame() {
		return game;
	}

	public void setGame(GameBoard game) {
		this.game = game;
	}

	public DisplayClock getClock() {
		return clock;
	}

	public LayoutManager getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(LayoutManager layoutType) {
		this.layoutType = layoutType;
	}

	public void setClock(DisplayClock clock) {
		this.clock = clock;
	}

	public void press() {
		theCommand.execute();
	}

	public void setGameDriver(GameDriver gameDriver) {
		this.gameDriver = gameDriver;
	}

	public GameDriver getGameDriver() {
		return gameDriver;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public Command getTheCommand() {
		return theCommand;
	}

	public void setTheCommand(Command theCommand) {
		this.theCommand = theCommand;
	}

	public ControlButtons(final GameBoard game) 
	{
		setStart(false);
		setPaused(false);
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		add(st_but);
		add(st_pse);
		add(st_undo);
		add(st_replay);
		add(st_quit);

		st_pse.setEnabled(false);
		st_undo.setEnabled(false);
		st_replay.setEnabled(false);
		st_but.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				st_pse.setEnabled(true);
				st_undo.setEnabled(true);
				st_replay.setEnabled(false);
				game.requestFocusInWindow();

				if (st_but.getText().equals("Stop")) 
				{
					st_but.setText("Restart");
					st_pse.setText("Pause");
					timerObs.getTimer().stop();
					st_pse.setEnabled(false);
					st_undo.setEnabled(false);
					st_replay.setEnabled(true);
				}

				else if (st_but.getText().equals("Start") || st_but.getText().equals("Restart")) 
				{
					StartCommand startCmd;
					timerObs = new TimerObservable();
					timerObs.addObserver((Observer) gameDriver.getGameBoard());
					timerObs.addObserver((Observer) gameDriver
							.getDisplayClock());
					timerObs.deleteObserver((Observer) gameDriver
							.getControlButtons());
					startCmd = new StartCommand(timerObs);
					setTheCommand(startCmd);
					press();
					st_but.setText("Stop");
				}
			}
		});

		st_pse.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				st_but.setEnabled(true);
				game.requestFocusInWindow();
				if (st_pse.getText().equals("Pause")) 
				{
					st_undo.setEnabled(true);
					PauseCommand pauseCmd;
					pauseCmd = new PauseCommand(timerObs);
					gameDriver.getControlButtons().setTheCommand(pauseCmd);
					gameDriver.getControlButtons().press();
					st_pse.setText("Resume");
				}
				else 
				{
					st_undo.setEnabled(true);
					isStart = true;
					ResumeCommand resumeCmd;
					resumeCmd = new ResumeCommand(timerObs);
					gameDriver.getControlButtons().setTheCommand(resumeCmd);
					gameDriver.getControlButtons().press();
					game.requestFocusInWindow();
					st_pse.setText("Pause");
				}
			}
		});

		st_undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				st_but.setEnabled(true);
				st_pse.setEnabled(true);
				st_undo.setEnabled(true);
				st_replay.setEnabled(false);
				timerObs.addObserver(gameDriver.getControlButtons());
				st_pse.setText("Resume");
				isStart = false;
				UndoCommand undoCmd;
				undoCmd = new UndoCommand(timerObs);
				setTheCommand(undoCmd);
				press();
			}
		});

		st_replay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				st_but.setEnabled(true);
				st_but.setText("Restart");
				st_pse.setEnabled(false);
				st_undo.setEnabled(false);
				st_replay.setEnabled(true);
				isStart = false;
				ReplayCommand replyCmd;
				timerObs.addObserver((Observer) gameDriver.getGameBoard());
				timerObs.addObserver((Observer) gameDriver.getDisplayClock());
				timerObs.addObserver((Observer) gameDriver.getControlButtons());
				replyCmd = new ReplayCommand(timerObs);
				setTheCommand(replyCmd);
				press();
			}
		});
		
		st_quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				System.exit(0);
			}
		});

		setBackground(Color.black);
	}

	@Override
	public void update(Observable o, Object objList) 
	{
		if (((ArrayList<?>) objList).get(((ArrayList<?>) objList).size() - 1) instanceof Number) 
		{
			setLayoutState((Integer) ((ArrayList<?>) objList)
					.get(((ArrayList<?>) objList).size() - 1));
		}
	}

	public int getLayoutState()
	{
		return layoutState;
	}

	public void setLayoutState(int layoutState)
	{
		this.layoutState = layoutState;
	}
}