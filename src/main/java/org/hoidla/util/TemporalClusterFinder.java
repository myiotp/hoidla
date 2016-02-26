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

package org.hoidla.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranab
 *
 */
public class TemporalClusterFinder {
	private List<Long> eventTimes = new ArrayList<Long>();
	private long timeHorizonStart;
	private long timeHorizonEnd;
	private long minSeparation;
	
	
	/**
	 * @param eventTimes
	 * @param timeHorizonStart
	 * @param timeHorizonEnd
	 * @param minSeparation
	 */
	public void initialize(List<Long> eventTimes, long timeHorizonStart,
			long timeHorizonEnd, long minSeparation) {
		this.eventTimes = eventTimes;
		this.timeHorizonStart = timeHorizonStart;
		this.timeHorizonEnd = timeHorizonEnd;
		this.minSeparation = minSeparation;
	}
	
	/**
	 * @return
	 */
	public List<TemporalCluster> findClusters() {
		List<TemporalCluster> clusters = new ArrayList<TemporalCluster>();
		
		return clusters;
	}
	
	
}
