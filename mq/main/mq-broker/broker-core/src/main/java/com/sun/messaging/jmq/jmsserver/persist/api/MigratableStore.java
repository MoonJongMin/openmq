/*
 * Copyright (c) 2000, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 */ 

package com.sun.messaging.jmq.jmsserver.persist.api;

import com.sun.messaging.jmq.jmsserver.core.BrokerAddress;
import com.sun.messaging.jmq.jmsserver.util.BrokerException;
import com.sun.messaging.jmq.jmsserver.cluster.api.FileTransferCallback;
import com.sun.messaging.jmq.jmsserver.cluster.api.ClusterProtocolHelper;

public interface MigratableStore extends FileTransferCallback {

    /**
     */
    public void initTakeoverBrokerStore(String groupName, 
                                       String nodeName,
                                       String masterHostPort, String uuid,
                                       BrokerAddress from, ClusterProtocolHelper cpi)
                                       throws BrokerException; 

    /**
     * @return the host:port of the broker that takes over this broker
     */
    public String takeoverME(String brokerID, Long syncTimeout)
    throws BrokerException; 


    /**
     */
    public String getMyEffectiveBrokerID(); 

}
