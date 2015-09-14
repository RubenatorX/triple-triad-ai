package com.dyllongagnier.triad.core;

import com.dyllongagnier.triad.card.UndeployedCard;

/**
 * This is an immutable object for the purpose of conveying rules.
 */
public class Rules 
{
	public final boolean isSuddenDeath;
	public final boolean isOrder;
	public final boolean isChaos;
	public final boolean isReverse;
	public final boolean isFallenAce;
	public final boolean isAscension;
	public final boolean isDescension;
		
	/**
	 * This method initializes an immutable Rules object.
	 * @param isSuddenDeath This indicates sudden death is in place.
	 * @param isOrder This indicates that order is in place.
	 * @param isChaos This indicates the chaos rule.
	 * @param isReverse This indicates the reverse rule.
	 * @param isFallenAce This indicates the fallen ace rule.
	 * @param isAscension This indicates the ascension rule.
	 * @param isDescension This indicates the descension rule.
	 * @param selfCards This is the card order to be used for isOrder for self. This may be null if order is false.
	 * @param opponentCards This is the card order to be used for isOrder for opponent. This may be null if order is false.
	 */
	public Rules(boolean isSuddenDeath, boolean isOrder, boolean isChaos, boolean isReverse, boolean isFallenAce,
			boolean isAscension, boolean isDescension, UndeployedCard[] selfCards, UndeployedCard[] opponentCards)
	{
		this.isSuddenDeath = isSuddenDeath;
		this.isOrder = isOrder;
		this.isChaos = isChaos;
		this.isReverse = isReverse;
		this.isFallenAce = isFallenAce;
		this.isAscension = isAscension;
		this.isDescension = isDescension;
	}
}
