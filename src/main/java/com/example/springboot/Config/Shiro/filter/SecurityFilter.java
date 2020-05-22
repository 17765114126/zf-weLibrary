package com.example.springboot.Config.Shiro.filter;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.util.Result;
import com.example.springboot.util.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.jasper.security.SecurityUtil;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
    }
//    private static final Log log = LogFactory.get(SecurityFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            String requri = req.getRequestURI();
            Map<String, String> params = new HashMap<>();
            for (Object name : request.getParameterMap().keySet()) {
                String v = request.getParameter(name.toString());
                if (v != null && v != "") {
                    params.put(name.toString(), v);
                }
            }
//            SuBusiness byId = businessService.getById(SysUtils.currentUser());
            //权限判断
//            if(!SecurityConstants.PATH_WHITE_LIST.contains(requri)){
//                SuBusiness sysBusiness = SecurityUtil.sysBusiness();
//                if(sysBusiness == null){
//                    response.getWriter().write(JSON.toJSONString(Result.with(ResultCodeEnum.NOT_LOGIN)));
//                    return;
//                }
//                SysUserService sysUserService = SpringUtils.getBean("sysUserService");//getBean的方式使用sysUserService内方法
//                CmsPermissionMapper cmsPermissionMapper = SpringUtils.getBean("cmsPermissionMapper");
//                int count = cmsPermissionMapper.selectCount(new QueryWrapper<CmsPermission>().lambda().eq(CmsPermission::getName,requri));
                //判断权限
//                if(count>0 && !sysUserService.hasPermission(requri)){
//                    response.getWriter().write(JSON.toJSONString(Result.with(ResultCodeEnum.NOT_AUTH)));
//                    return;
//                }
//                Integer modelId = null;
//                CmsButtonMapper cmsButtonMapper = SpringUtils.getBean("cmsButtonMapper");
//                CmsButton b = cmsButtonMapper.selectOne(new QueryWrapper<CmsButton>().lambda().eq(CmsButton::getUrl,requri));
//                String optName = "";
//                if(b!=null){
//                    CmsModelMapper cmsModelMapper = SpringUtils.getBean("cmsModelMapper");
//                    optName = b.getName();
//                    modelId = b.getModelId();
//                    CmsModel mm = cmsModelMapper.selectById(modelId);
//                    optName = mm.getName() + ":" + optName;
//                    Integer parentId = mm.getPid();
//                    while (parentId != 0) {
//                        CmsModel pm = cmsModelMapper.selectById(parentId);
//                        parentId = pm.getPid();
//                        optName = pm.getName() + "-" + optName;
//                    }
//                }
//            }
            chain.doFilter(request, response);
        }catch (Exception e){
//            log.error("",e);
            response.getWriter().write(JSON.toJSONString(Result.with(ResultCodeEnum.INNER_ERROR)));
        }
    }

    @Override
    public void destroy() {
    }
}
