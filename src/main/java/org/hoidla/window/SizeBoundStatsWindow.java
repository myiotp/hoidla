/*
 * hoidla: various streaming algorithms for Big Data solutions
 * Author: Pranab Ghosh
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.hoidla.window;

/**
 * @author pranab
 *
 */
public class SizeBoundStatsWindow  extends SizeBoundWindow<Integer> {
	private double mean;
	private double stdDev;
	private double sum;
	private double sumSq;
	private int count;
	private boolean processed;
	
	public SizeBoundStatsWindow(int maxSize) {
		super(maxSize);
	}
	
	public void add(Integer value) {
		processed = false;
		super.add(value);
	}
	
	public  void processFullWindow() {
		sum = sumSq = 0;
		count = 0;
		for (Integer val : dataWindow) {
			sum += val;
			sumSq += val * val;
			++count;
		}
		
		mean = sum / count;
		stdDev = Math.sqrt(sumSq / count - mean * mean);
		processed = true;
	}

	public double getMean() {
		return mean;
	}

	public double getStdDev() {
		return stdDev;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	public void forcedProcess() {
		if (!processed) {
			 processFullWindow();
		}
	}
}
