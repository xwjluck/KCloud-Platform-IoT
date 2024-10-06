/*
 * Copyright (c) 2022-2024 KCloud-Platform-IoT Author or Authors. All Rights Reserved.
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

package org.laokou.im.gatewayimpl.rpc;

import org.laokou.common.i18n.dto.Result;
import org.laokou.im.dto.clientobject.UserProfileCO;
import org.laokou.im.gatewayimpl.rpc.factory.UserFeignClientFallbackFactory;
import org.laokou.im.gatewayimpl.rpc.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.laokou.common.i18n.common.constant.Constant.AUTHORIZATION;
import static org.laokou.im.common.constant.Constant.LAOKOU_ADMIN;

/**
 * @author laokou
 */
@FeignClient(name = LAOKOU_ADMIN, contextId = "user", path = "/v3/users", fallback = UserFeignClientFallback.class,
		fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

	@GetMapping("profile")
	Result<UserProfileCO> getProfileV3(@RequestHeader(AUTHORIZATION) String Authorization);

}