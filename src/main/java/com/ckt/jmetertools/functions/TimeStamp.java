package com.ckt.jmetertools.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import com.ckt.utils.TimeUtils;

/**
 * 
 * @ClassName: TimeStamp 
 * @Description: to get time stamp
 * @author jianbin.zhong
 * @date 2017年9月28日 上午10:56:13 
 *
 */
public class TimeStamp extends AbstractFunction{
	
	private static final List<String> desc = new LinkedList<String>();
	private static final String KEY = "_GetTimeStamp";
	private static int MAX_PARAM_COUNT = 1;
    private static final int MIN_PARAM_COUNT = 0;
    private Object[] values;
    
    static{
    	desc.add("input a interval like 1000、2000");
    }
	@Override
	public List<String> getArgumentDesc() {
		// TODO Auto-generated method stub
		return desc;
	}

	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
		TimeUtils utils = new TimeUtils();
		if (values.length == 0) {
			return utils.getTimestamp();
		}else if (values.length == 1) {
			String value =new String(((CompoundVariable)values[0]).execute().trim());
			if (utils.isNumber(value)) {
				return utils.getTimestamp(Long.parseLong(value));
			}else {
				System.out.println("parameter type error, please check!");
				return null;
			}
		}else {
			System.out.println("parameter number error, please check!");
			return null;
		}
	}

	@Override
	public String getReferenceKey() {
		return KEY;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> arg0) throws InvalidVariableException {
		//检查并获取参数
		checkParameterCount(arg0, MIN_PARAM_COUNT,MAX_PARAM_COUNT);
		values = arg0.toArray();	
	}
}
