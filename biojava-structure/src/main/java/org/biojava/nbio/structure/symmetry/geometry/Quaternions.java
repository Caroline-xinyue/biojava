package org.biojava.nbio.structure.symmetry.geometry;

import javax.vecmath.Point3d;
import javax.vecmath.Quat4d;

/**
 * Quaternions is a static Class that contains methods for calculating and using
 * quaternions. It assumes the use of {@link Quat4d} Class from vecmath to
 * represent quaternions, and it also implements some of the methods that the
 * library is missing.
 * <p>
 * A Quaternion is a four-dimensional vector used to describe a
 * three-dimensional attitude representation (axis and angle of rotation).
 * 
 * @author Aleix Lafita
 * @since 5.0.0
 *
 */
public class Quaternions {

	/** Prevent instantiation */
	private Quaternions() {
	}

	/**
	 * The orientation metric is obtained by comparing the quaternion
	 * orientations of two sets of points in 3D.
	 * <p>
	 * First, the quaternion orientation of each set of points is calculated
	 * using their principal axes with {@link #orientation(Point3d[])}. Then,
	 * the two quaternions are compared using the method
	 * {@link #orientationMetric(Quat4d, Quat4d)}.
	 * 
	 * @param a
	 *            array of Point3d
	 * @param b
	 *            array of Point3d
	 * @return the quaternion orientation metric
	 */
	public static double orientationMetric(Point3d[] a, Point3d[] b) {

		Quat4d qa = orientation(a);
		Quat4d qb = orientation(b);

		return orientationMetric(qa, qb);
	}

	/**
	 * The orientation metric is obtained by comparing two unit quaternion
	 * orientations.
	 * <p>
	 * The two quaternions are compared using the formula: d(q1,q2) =
	 * arccos(|q1*q2|). The range of the metric is [0, Pi/2], where 0 means the
	 * same orientation and Pi/2 means the opposite orientation.
	 * <p>
	 * The formula is taken from: Huynh, D. Q. (2009). Metrics for 3D rotations:
	 * comparison and analysis. Journal of Mathematical Imaging and Vision,
	 * 35(2), 155–164. http://doi.org/10.1007/s10851-009-0161-2
	 * 
	 * @param q1
	 *            quaternion as Quat4d object
	 * @param q2
	 *            quaternion as Quat4d object
	 * @return the quaternion orientation metric
	 */
	public static double orientationMetric(Quat4d q1, Quat4d q2) {
		return Math.acos(dotProduct(q1, q2));
	}

	/**
	 * The orientation represents the rotation of the principal axes with
	 * respect to the axes of the coordinate system (unit vectors [1,0,0],
	 * [0,1,0] and [0,0,1]).
	 * <p>
	 * The orientation can be expressed as a unit quaternion.
	 * 
	 * @param points
	 *            array of Point3d
	 * @return the orientation of the point cloud as a unit quaternion
	 */
	public static Quat4d orientation(Point3d[] points) {

		MomentsOfInertia moi = new MomentsOfInertia();

		for (Point3d p : points)
			moi.addPoint(p, 1.0);

		// Convert rotation matrix to quaternion
		Quat4d quat = new Quat4d();
		quat.set(moi.getOrientationMatrix());

		return quat;
	}

	/**
	 * Return the euclidean length of the quaternion (the norm, the magnitude).
	 * <p>
	 * The length of the quaternion is obtained by taking the square root of the
	 * dot product of the quaternion with its conjugate.
	 * 
	 * @param q
	 *            quaternion as Quat4d object
	 * @return the euclidean length of the quaterion
	 */
	public static double length(Quat4d q) {
		return Math.sqrt(lengthSquared(q));
	}

	/**
	 * Return the squared euclidean length of the quaternion. It is equivalent
	 * to [{@link #length(Quat4d)}]^2.
	 * <p>
	 * The squared length of the quaternion is obtained by the dot product of
	 * the quaternion with its conjugate.
	 * 
	 * @param q
	 *            quaternion as Quat4d object
	 * @return the euclidean length of the quaterion
	 */
	public static double lengthSquared(Quat4d q) {
		return q.x * q.x + q.y * q.y + q.z * q.z + q.w * q.w;
	}

	/**
	 * Compute the dot (inner) product of two quaternions.
	 * 
	 * @param q1
	 *            quaternion as Quat4d object
	 * @param q2
	 *            quaternion as Quat4d object
	 * @return the value of the quaternion dot product
	 */
	public static double dotProduct(Quat4d q1, Quat4d q2) {
		return q1.x * q2.x + q1.y * q2.y + q1.z * q2.z + q1.w * q2.w;
	}

}
