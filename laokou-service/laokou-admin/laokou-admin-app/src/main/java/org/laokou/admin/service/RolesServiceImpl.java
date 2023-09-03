/*
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
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

package org.laokou.admin.service;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.client.api.RolesServiceI;
import org.laokou.admin.client.dto.common.clientobject.OptionCO;
import org.laokou.admin.client.dto.role.RoleGetQry;
import org.laokou.admin.client.dto.role.RoleInsertCmd;
import org.laokou.admin.client.dto.role.RoleListQry;
import org.laokou.admin.client.dto.role.RoleOptionListQry;
import org.laokou.admin.client.dto.role.clientobject.RoleCO;
import org.laokou.admin.command.role.RoleInsertCmdExe;
import org.laokou.admin.command.role.query.RoleGetQryExe;
import org.laokou.admin.command.role.query.RoleListQryExe;
import org.laokou.admin.command.role.query.RoleOptionListQryExe;
import org.laokou.common.i18n.dto.Datas;
import org.laokou.common.i18n.dto.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laokou
 */
@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesServiceI {

	private final RoleListQryExe roleListQryExe;

	private final RoleOptionListQryExe roleOptionListQryExe;

	private final RoleGetQryExe roleGetQryExe;

	private final RoleInsertCmdExe roleInsertCmdExe;

	@Override
	public Result<Datas<RoleCO>> list(RoleListQry qry) {
		return roleListQryExe.execute(qry);
	}

	@Override
	public Result<List<OptionCO>> optionList(RoleOptionListQry qry) {
		return roleOptionListQryExe.execute(qry);
	}

	@Override
	public Result<RoleCO> get(RoleGetQry qry) {
		return roleGetQryExe.execute(qry);
	}

	@Override
	public Result<Boolean> insert(RoleInsertCmd cmd) {
		return roleInsertCmdExe.execute(cmd);
	}

}