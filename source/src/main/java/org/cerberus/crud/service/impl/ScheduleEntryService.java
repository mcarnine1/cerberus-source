/* Cerberus Copyright (C) 2013 - 2017 cerberustesting
DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

This file is part of Cerberus.

Cerberus is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Cerberus is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.cerberus.crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cerberus.crud.entity.ScheduleEntry;
import org.cerberus.util.answer.AnswerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cerberus.crud.dao.IScheduleEntryDAO;
import org.cerberus.crud.service.IScheduleEntryService;
import org.cerberus.engine.scheduler.SchedulerInit;
import org.cerberus.util.answer.Answer;

/**
 *
 * @author cdelage
 */

@Service
public class ScheduleEntryService implements IScheduleEntryService{
    
    @Autowired
    IScheduleEntryDAO schedulerDao;
    private static final Logger LOG = LogManager.getLogger(ScheduleEntryService.class);

    @Override
    public AnswerItem<ScheduleEntry> readbykey (Integer id){
    AnswerItem<ScheduleEntry> ans = new AnswerItem();
    ans = schedulerDao.readByKey(id);
    return ans;
    }
    
    @Override
    public AnswerItem<List> readAllActive (){
    AnswerItem<List> ans = new AnswerItem();
    ans = schedulerDao.readAllActive();
    return ans;
    }
    
    @Override
    public AnswerItem<Integer> create (ScheduleEntry scheduleentry){
        LOG.debug("scheduleentryservice.create");
        AnswerItem<Integer> response = new AnswerItem();
        response = schedulerDao.create(scheduleentry);
        return response;
    }  
    
    @Override
    public Answer update (ScheduleEntry scheduleentry){
        Answer response = new Answer();
        response = schedulerDao.update(scheduleentry);
        return response;
    }
    
    @Override
    public Answer delete(ScheduleEntry object){
    Answer response = new Answer();
    response = schedulerDao.delete(object);
    return response;
    };
    
    
}
