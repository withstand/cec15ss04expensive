

prefix = 'results\simulannealbnd\resultfile';
% with output filel prefix,
% canbe dir\\filenameprefix or dir/filenameprefix
prob = cec2015.CEC15Problems(prefix);
% with 
%   prob = cec2015.CEC15Problems();
% no function evaluation counting or result recording, the only valid
% method are 
%   prob.eval(x,dim, numberofx, function_number)



for runtime = 1:20
    % specify runtime for prob
    setNumberOfRun(prob, runtime);
    for dimension = [10,30]    
        
        % recording rules define at which evaluation point to record
        % current best fx and corresponding x are recorded in memory
        
        % recording rules are dimension related
       
        for func_num = 1:15         
            
            
            x0 = -100+200*rand(dimension,1);
            
            func = @(x)(eval(prob,x,dimension,1,func_num));
            [x,y] = simulannealbnd(func,x0,...
                -100*ones(dimension,1),100*ones(dimension,1),...
                saoptimset('display','iter','MaxFunEvals',50*dimension));
            
        end
        
    end
    
    
end

% write results and statistics to files
writeResultToFiles(prob);
