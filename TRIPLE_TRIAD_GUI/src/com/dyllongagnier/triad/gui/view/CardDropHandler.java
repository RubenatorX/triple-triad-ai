package com.dyllongagnier.triad.gui.view;

import java.awt.Container;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JComponent;

public class CardDropHandler implements DropTargetListener
{
	@Override
	public void dragEnter(DropTargetDragEvent dtde)
	{
		if (dtde.isDataFlavorSupported(CardFlavor.cardFlavor))
			dtde.acceptDrag(DnDConstants.ACTION_MOVE);
		else
			dtde.rejectDrag();
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde)
	{
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde)
	{
	}

	@Override
	public void dragExit(DropTargetEvent dte)
	{
	}

	@Override
	public void drop(DropTargetDropEvent dtde)
	{
		if (dtde.isDataFlavorSupported(CardFlavor.cardFlavor))
		{
			Transferable trans = dtde.getTransferable();
			try
			{
				Object data = trans.getTransferData(CardFlavor.cardFlavor);
				CardWindow card =(CardWindow)data;
				DropTargetContext context = dtde.getDropTargetContext();
				JComponent comp = (JComponent)context.getComponent();
				Container parent = comp.getParent();
				if (parent != null)
					parent.remove(card);
				comp.add(card);
				dtde.acceptDrop(DnDConstants.ACTION_MOVE);
				comp.validate();
				comp.repaint();
				
				dtde.dropComplete(true);
			}
			catch (Exception e)
			{
				dtde.rejectDrop();
				dtde.dropComplete(false);
			}
		}
		else
		{
			dtde.rejectDrop();
			dtde.dropComplete(false);
		}
	}
}
