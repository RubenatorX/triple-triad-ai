package com.dyllongagnier.triad.gui.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.dyllongagnier.triad.gui.controller.Players;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import com.dyllongagnier.triad.core.AscensionRule;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class TriadSettings extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final String infinity = "INF";
	
	private JTextField maxThreadValue;
	private JTextField maxThinkTime;
	
	public TriadSettings() 
	{
		setTitle("Settings");
		setSize(new Dimension(299, 368));
		JComboBox<AscensionRule> ascensionRuleValue = new JComboBox<>();
		ascensionRuleValue.setModel(new DefaultComboBoxModel<AscensionRule>(AscensionRule.values()));
		
		JLabel lblAscensionRule = new JLabel("Ascension Rule");
		
		JCheckBox chckbxFallenAce = new JCheckBox("Fallen Ace");
		
		JCheckBox chckbxReverse = new JCheckBox("Reverse");
		
		JCheckBox chckbxPlus = new JCheckBox("Plus");
		
		JCheckBox chckbxSame = new JCheckBox("Same");
		
		JCheckBox chckbxCombo = new JCheckBox("Combo");
		
		JCheckBox chckbxSuddenDeath = new JCheckBox("Sudden Death");
		
		JLabel lblMaximumThreads = new JLabel("Maximum Threads:");
		
		maxThinkTime = new JTextField();
		maxThinkTime.setText("INF");
		maxThinkTime.setHorizontalAlignment(SwingConstants.RIGHT);
		maxThinkTime.setColumns(10);
		
		maxThreadValue = new JTextField();
		maxThreadValue.setHorizontalAlignment(SwingConstants.RIGHT);
		maxThreadValue.setColumns(10);
		maxThreadValue.setText(String.valueOf(Runtime.getRuntime().availableProcessors()));
		
		Runnable executeOptions = () ->
		{
			Players.setAscensionRule((AscensionRule)ascensionRuleValue.getSelectedItem());
			Players.setIsFallenAce(chckbxFallenAce.isSelected());
			Players.setIsReverse(chckbxReverse.isSelected());
			Players.setIsPlus(chckbxPlus.isSelected());
			Players.setIsSame(chckbxSame.isSelected());
			Players.setIsCombo(chckbxCombo.isSelected());
			Players.setIsSuddenDeath(chckbxSuddenDeath.isSelected());
			Players.setMaxThreads(Integer.parseInt(maxThreadValue.getText()));
			TriadSettings.parseThinkTime(maxThinkTime.getText());
		};
		
		Runnable reset = () ->
		{
			Players.setDefaultOptions();
			Players.setAscensionRule(AscensionRule.NONE);
			chckbxFallenAce.setSelected(false);
			chckbxReverse.setSelected(false);
			chckbxPlus.setSelected(false);
			chckbxSame.setSelected(false);
			chckbxCombo.setSelected(false);
			chckbxSuddenDeath.setSelected(false);
			maxThreadValue.setText(String.valueOf(Players.getMaxThreads()));
			maxThinkTime.setText(TriadSettings.infinity);
		};
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener((act) -> this.okEvent(executeOptions, reset));
		
		JLabel maxThinkTimeLabel = new JLabel("Maximum Think Time:");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxCombo)
								.addComponent(chckbxPlus)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxFallenAce)
									.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxReverse)
										.addComponent(chckbxSame)
										.addComponent(chckbxSuddenDeath)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblAscensionRule)
											.addGap(18)
											.addComponent(ascensionRuleValue, 0, 134, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(maxThinkTimeLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMaximumThreads))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(maxThreadValue, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(maxThinkTime, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
									.addGap(7))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(btnOk)))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAscensionRule)
						.addComponent(ascensionRuleValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumThreads)
						.addComponent(maxThreadValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(maxThinkTimeLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(maxThinkTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxFallenAce)
						.addComponent(chckbxReverse))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxPlus)
						.addComponent(chckbxSame))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCombo)
						.addComponent(chckbxSuddenDeath))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private void okEvent(Runnable toRun, Runnable reset)
	{
		try
		{
			toRun.run();
			Players.verifyOptionValidity();
			this.setVisible(false);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Invalid settings configuration.");
			reset.run();
		}
	}
	
	private static void parseThinkTime(String str)
	{
		if (str.toUpperCase().equals(TriadSettings.infinity))
			Players.setTimeout(Integer.MAX_VALUE);
		else
			Players.setTimeout(Double.parseDouble(str));
	}
}
