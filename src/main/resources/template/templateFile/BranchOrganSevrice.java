package com.posp.oos.web.srv.service.temp;

import com.posp.oos.web.srv.model.vo.req.BranchOrganAddReqVo;
import com.posp.oos.web.srv.model.vo.req.BranchOrganListReqVo;
import com.posp.oos.web.srv.model.vo.res.BranchOrganAddResVo;
import com.posp.oos.web.srv.model.vo.res.BranchOrganListResVo;

public interface BranchOrganSevrice {

    public BranchOrganListResVo branchOrganList(BranchOrganListReqVo branchOrganListReqVo);

