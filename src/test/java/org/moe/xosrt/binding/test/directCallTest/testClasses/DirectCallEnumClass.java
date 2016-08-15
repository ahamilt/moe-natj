/*
Copyright 2014-2016 Intel Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.moe.xosrt.binding.test.directCallTest.testClasses;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Selector;
import org.moe.xosrt.binding.test.common.xNSString;
import org.moe.xosrt.binding.test.directCallTest.testClasses.Enums.BaseEnumPtr;

@ObjCClassName("DirectCallEnumClass")
public class DirectCallEnumClass extends DirectCallEnumParent {

	static {
		NatJ.register();
	}

	protected DirectCallEnumClass(Pointer peer) {
		super(peer);
	}

	@Selector("alloc")
	@Owned
	public static native DirectCallEnumClass alloc();

	
	@Selector("init")
	public native DirectCallEnumClass init();
	
	@Selector("initWithMock:")
	public native DirectCallEnumClass initWithMock(boolean mock);
	
	public String printInvocation() {
		return printInvocations(this).toString();
	}
	
	@Selector("printInvocations:")
	public static native xNSString printInvocations(DirectCallEnumClass mocked);
	
	@Selector("methodDCallWBaseEnumArg:")
	public native void javaMethodDCallWBaseEnumArg(long en);
	
	@Selector("methodDCallWBaseEnumRet:")
	public native long javaMethodDCallWBaseEnumRet(long en);
	
	@Selector("methodDCallWBaseEnumPtrArg:")
	public native void javaMethodDCallWBaseEnumPtrArg(BaseEnumPtr ptr);
	
	@Selector("methodDCallWBaseEnumPtrRet:")
	public native BaseEnumPtr javaMethodDCallWBaseEnumPtrRet(long en);

}