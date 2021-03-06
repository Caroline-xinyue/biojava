/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
package org.biojava.nbio.structure.symmetry.core;

import java.io.Serializable;

/**
 * The QuatSymmetryParameters specify the options used for the detection of
 * quaternary symmetry in structures using the {@link QuatSymmetryDetector}.
 * 
 * @author Peter Rose
 * @author Aleix Lafita
 *
 */
public class QuatSymmetryParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	private double rmsdThreshold = 7.0;
	private double angleThreshold = 10.0; // max angle deviation for C2 solver
	// if a structure has both cyclic and helical symmetry (i.e., 3J4F: C2 and
	// H),
	// then helical symmetry is assigned if Rmsd(helical) - Rmsd(cyclic) <=
	// helixRmsdThreshold
	// A slightly positive value gives preference to helical, if the RMSDs for
	// the two symmetries
	// are almost identical
	private double helixRmsdThreshold = 0.05;
	private double helixRmsdToRiseRatio = 0.5; // rmsd must be < 0.5 * abs(rise)
												// (previously set to 0.75)
	private double minimumHelixRise = 1.0;
	private double minimumHelixAngle = 5.0; // min helix angle to differentiate
											// it from a translational repeat
	private int maximumLocalCombinations = 50000; // max number of combinations
													// to try for local symmetry
													// calculation
	private int maximumLocalResults = 1000;
	private int maximumLocalSubunits = 20; // maximum number of subunits for
											// local symmetry calculations
	private double localTimeLimit = 120; // time limit for local calculations in
											// seconds
	private boolean onTheFly = true;

	/**
	 * @return the rmsdThreshold
	 */
	public double getRmsdThreshold() {
		return rmsdThreshold;
	}

	/**
	 * @param rmsdThreshold
	 *            the rmsdThreshold to set
	 */
	public void setRmsdThreshold(double rmsdThreshold) {
		this.rmsdThreshold = rmsdThreshold;
	}

	public double getAngleThreshold() {
		return angleThreshold;
	}

	public void setAngleThreshold(double angleThreshold) {
		this.angleThreshold = angleThreshold;
	}

	public double getHelixRmsdThreshold() {
		return helixRmsdThreshold;
	}

	public void setHelixRmsdThreshold(double helixRmsdThreshold) {
		this.helixRmsdThreshold = helixRmsdThreshold;
	}

	/**
	 * @return the helixRmsdToRiseRatio
	 */
	public double getHelixRmsdToRiseRatio() {
		return helixRmsdToRiseRatio;
	}

	/**
	 * @param helixRmsdToRiseRatio
	 *            the helixRmsdToRiseRatio to set
	 */
	public void setHelixRmsdToRiseRatio(double helixRmsdToRiseRatio) {
		this.helixRmsdToRiseRatio = helixRmsdToRiseRatio;
	}

	public double getMinimumHelixRise() {
		return minimumHelixRise;
	}

	public void setMinimumHelixRise(double minimumHelixRise) {
		this.minimumHelixRise = minimumHelixRise;
	}

	public double getMinimumHelixAngle() {
		return minimumHelixAngle;
	}

	public void setMinimumHelixAngle(double minimumHelixAngle) {
		this.minimumHelixAngle = minimumHelixAngle;
	}

	public int getMaximumLocalCombinations() {
		return maximumLocalCombinations;
	}

	public void setMaximumLocalCombinations(int maximumLocalCombinations) {
		this.maximumLocalCombinations = maximumLocalCombinations;
	}

	/**
	 * @return the maximumLocalResults
	 */
	public int getMaximumLocalResults() {
		return maximumLocalResults;
	}

	/**
	 * @return the maximumLocalSubunits
	 */
	public int getMaximumLocalSubunits() {
		return maximumLocalSubunits;
	}

	/**
	 * @param maximumLocalSubunits
	 *            the maximumLocalSubunits to set
	 */
	public void setMaximumLocalSubunits(int maximumLocalSubunits) {
		this.maximumLocalSubunits = maximumLocalSubunits;
	}

	/**
	 * @param maximumLocalResults
	 *            the maximumLocalResults to set
	 */
	public void setMaximumLocalResults(int maximumLocalResults) {
		this.maximumLocalResults = maximumLocalResults;
	}

	/**
	 * @return the localTimeLimit
	 */
	public double getLocalTimeLimit() {
		return localTimeLimit;
	}

	/**
	 * @param localTimeLimit
	 *            the localTimeLimit to set
	 */
	public void setLocalTimeLimit(double localTimeLimit) {
		this.localTimeLimit = localTimeLimit;
	}

	/**
	 * On-the-fly Jmol bioassembly generation.
	 * 
	 * @return true if Jmol on the fly bioassembly generation is used
	 */
	public boolean isOnTheFly() {
		return onTheFly;
	}

	/**
	 * On-the-fly Jmol bioassembly generation.
	 * 
	 * @param useJmolBioAssemblies
	 *            true if Jmol on the fly bioassembly generation is used, false
	 *            otherwise
	 */
	public void setOnTheFly(boolean useJmolBioAssemblies) {
		this.onTheFly = useJmolBioAssemblies;
	}

	@Override
	public String toString() {
		return "QuatSymmetryParameters [rmsdThreshold=" + rmsdThreshold
				+ ", angleThreshold=" + angleThreshold
				+ ", helixRmsdThreshold=" + helixRmsdThreshold
				+ ", helixRmsdToRiseRatio=" + helixRmsdToRiseRatio
				+ ", minimumHelixRise=" + minimumHelixRise
				+ ", minimumHelixAngle=" + minimumHelixAngle
				+ ", maximumLocalCombinations=" + maximumLocalCombinations
				+ ", maximumLocalResults=" + maximumLocalResults
				+ ", maximumLocalSubunits=" + maximumLocalSubunits
				+ ", localTimeLimit=" + localTimeLimit + ", onTheFly="
				+ onTheFly + "]";
	}
}
