

prefix = 'result/201410091125/test_run';
% with output filel prefix,
% canbe dir\\filenameprefix or dir/filenameprefix
prob = cec2015.CEC15Problems(prefix);
% with 
%   prob = cec2015.CEC15Problems();
% no function evaluation counting or result recording, the only valid
% method are 
%   prob.eval(x,dim, numberofx, function_number)



for runtime = 1:5
    % specify runtime for prob
    setCurrentRun(prob, runtime);
    for dimension = [10,30]    
        
        % recording rules define at which evaluation point to record
        % current best fx and corresponding x are recorded in memory
        
        % recording rules are dimension related
       
        for func_num = 1:15
            if dimension == 2 && ...
                    ((func_num >= 17 && func_num <= 22) ||...
                    (func_num >= 29 && func_num <= 30))
                continue;
            end
            
            
            
            
            x0 = -100+200*rand(dimension,1);
            
            % prob.eval(x, dimesnion, numberofx, function_number)
            % several evaluations could be make in the same time with
            % numberofx > 1, x must be array with length
            % dimension*numberofx
            [x,y] = patternsearch(@(x)(eval(prob,x,dimension,1,func_num)),x0,[],[],[],[],...
                -100*ones(dimension,1),100*ones(dimension,1),[],...
                psoptimset('display','off','MaxFunEvals',500*dimension));
            
        end
        
    end
    
    % prob.nextRun();
    
end

% write results and statistics to files
writeResultToFiles(prob);
