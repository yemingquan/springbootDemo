package com.posp.oos.web.srv.service.temp.impl;

import org.springframework.stereotype.Service;

import com.posp.oos.web.srv.model.vo.req.BranchOrganAddReqVo;
import com.posp.oos.web.srv.model.vo.req.BranchOrganListReqVo;
import com.posp.oos.web.srv.model.vo.res.BranchOrganAddResVo;
import com.posp.oos.web.srv.model.vo.res.BranchOrganListResVo;
import com.posp.oos.web.srv.model.vo.res.body.BranchOrganAddResBodyVo;
import com.posp.oos.web.srv.service.temp.BranchOrganSevrice;
import com.posp.oos.web.srv.util.MyMessageUtil;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("BranchOrganSevrice")
@Api(description = "分支机构服务类")
public class BranchOrganSevriceImpl implements BranchOrganSevrice {

    /**
     * xxx
     */
    public BranchOrganAddResVo branchOrganAdd(BranchOrganAddReqVo reqVo) {
        log.info(reqVo.toString());
        BranchOrganAddResVo resVo = new BranchOrganAddResVo();
        resVo.setHead(MyMessageUtil.getSuccessHead());
        resVo.setBody(new BranchOrganAddResBodyVo());
        log.info(reqVo.toString());
        return resVo;
    }


