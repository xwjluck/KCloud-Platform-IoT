/*
 * Copyright (c) 2022-2025 KCloud-Platform-IoT Author or Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.laokou.admin.loginLog.command.query;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.loginLog.convertor.LoginLogConvertor;
import org.laokou.admin.loginLog.dto.LoginLogGetQry;
import org.laokou.admin.loginLog.dto.clientobject.LoginLogCO;
import org.laokou.admin.loginLog.gatewayimpl.database.LoginLogMapper;
import org.laokou.common.i18n.dto.Result;
import org.springframework.stereotype.Component;

/**
 * 查看登录日志请求执行器.
 *
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class LoginLogGetQryExe {

	private final LoginLogMapper loginLogMapper;

	public Result<LoginLogCO> execute(LoginLogGetQry qry) {
		return Result.ok(LoginLogConvertor.toClientObject(loginLogMapper.selectById(qry.getId())));
	}

}
