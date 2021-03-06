package org.nmdp.kafkaproducer.kafka;

/**
 * Created by Andrew S. Brown, Ph.D., <andrew@nmdp.org>, on 6/16/17.
 * <p>
 * service-kafka-producer
 * Copyright (c) 2012-2017 National Marrow Donor Program (NMDP)
 * <p>
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 3 of the License, or (at
 * your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library;  if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.
 * <p>
 * > http://www.fsf.org/licensing/licenses/lgpl.html
 * > http://www.opensource.org/licenses/lgpl-license.php
 */

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class KafkaProducerCallback implements Callback {

    private static final Logger LOG = Logger.getLogger(KafkaProducerCallback.class);

    private Boolean isComplete;

    public KafkaProducerCallback() {
        this.isComplete = false;
    }

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            LOG.error("Error on kafka message production.", exception);
        }

        isComplete = true;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }
}
