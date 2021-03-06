/*
 * Copyright (c) 2013 Uwe B. Meding <uwe@uwemeding.com>
 *
 * This file is part of UM/PCA
 * This PCA software is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Final Term is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with UM/PCA.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.uwemeding.pca;

/**
 * Create a trajectory style matrix from a vector.
 *
 * @author uwe
 */
public class TrajectoryMatrix extends Matrix {

	public TrajectoryMatrix(double[] v, int ncols) {
		super(v.length - ncols + 1, ncols);
		double[][] arr = getArray();
		int nrows = getNRows();
		int pos = 0; // position in vector

		for (int i = 0; i < nrows; i++) {
			double value = v[pos++];
			int availCols = i < ncols ? i + 1 : ncols;
			for (int j = 0, m = i; j < availCols && m >= 0; j++, m--) {
				arr[m][j] = value;
			}
		}
		for (int i = 1; i < ncols; i++) {
			double value = v[pos++];
			for (int j = i, m = nrows - 1; j < ncols && m > 0; j++, m--) {
				arr[m][j] = value;
			}
		}
	}
}
